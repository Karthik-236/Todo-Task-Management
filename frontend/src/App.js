import React, { useEffect, useState } from 'react';
import axios from 'axios';
import TodoForm from './components/TodoForm';
import TodoList from './components/TodoList';
import TodoHistory from './components/TodoHistory';
import UserForm from './components/UserForm';
import './App.css';

function App() {
  const [todos, setTodos] = useState([]);
  const [users, setUsers] = useState([]);
  const [selectedTodoId, setSelectedTodoId] = useState(null);

  const fetchTodos = () => {
    axios.get('http://localhost:8080/api/todos')
      .then(res => setTodos(res.data));
  };

  const fetchUsers = () => {
    axios.get('http://localhost:8080/api/users')
      .then(res => setUsers(res.data));
  };

  const addTodo = (todo) => {
    axios.post('http://localhost:8080/api/todos', todo)
      .then(fetchTodos);
  };

  const updateTodo = (id, todo) => {
    axios.put(`http://localhost:8080/api/todos/${id}`, todo)
      .then(fetchTodos);
  };

  const deleteTodo = (id) => {
    axios.delete(`http://localhost:8080/api/todos/${id}`)
      .then(fetchTodos);
  };

  const assignUser = (todoId, userId) => {
    axios.post(`http://localhost:8080/api/todos/${todoId}/assign/${userId}`)
      .then(fetchTodos);
  };

  const addUser = (user) => {
    axios.post('http://localhost:8080/api/users', user)
      .then(fetchUsers);
  };

  useEffect(() => {
    fetchTodos();
    fetchUsers();
  }, []);

  return (
    <div className="app-container">
      <h1>📝 Todo Task Manager</h1>
      <TodoForm onAdd={addTodo} />
      <UserForm onAddUser={addUser} />
      <TodoList
        todos={todos}
        users={users}
        onUpdate={updateTodo}
        onDelete={deleteTodo}
        onAssign={assignUser}
        onViewHistory={setSelectedTodoId}
      />
      {selectedTodoId && (
        <div className="history-section">
          <h2>📜 Todo History</h2>
          <TodoHistory todoId={selectedTodoId} />
        </div>
      )}
    </div>
  );
}

export default App;
