import React from 'react';
import UserDropdown from './Userdropdown';


function TodoList({ todos, users, onUpdate, onDelete, onAssign, onViewHistory }) {
  const handleEdit = (todo) => {
    const newTitle = prompt("Edit title:", todo.title);
    if (newTitle) {
      console.log("Editing todo:", todo.todoId, "New title:", newTitle);
      onUpdate(todo.todoId, { ...todo, title: newTitle });
    }
  };

  const handleDelete = (todoId) => {
    console.log("Deleting todo with ID:", todoId);
    onDelete(todoId);
  };

  const handleAssign = (todoId, userId) => {
    console.log("Assigning todo ID:", todoId, "to user ID:", userId);
    onAssign(todoId, userId);
  };

  return (
    <div className="todo-list">
      {todos.map(todo => (
        <div key={todo.todoId} className="todo-card">
          <h3>
            {todo.title}
            {todo.isActive
              ? <span className="active-tag">Active</span>
              : <span className="inactive-tag">Inactive</span>}
          </h3>
          <ul>
            {todo.listOfItems.map((item, i) => <li key={i}>{item}</li>)}
          </ul>
          <p>Status: <strong>{todo.status}</strong></p>
          <div className="todo-actions">
            <button onClick={() => handleEdit(todo)}>Edit</button>
            <button onClick={() => handleDelete(todo.todoId)}>Delete</button>
            <UserDropdown
              users={users}
              onAssign={(userId) => handleAssign(todo.todoId, userId)}
            />
            <button onClick={() => {
              console.log("Viewing history for todo ID:", todo.todoId);
              onViewHistory(todo.todoId);
            }}>
              View History
            </button>
          </div>
        </div>
      ))}
    </div>
  );
}

export default TodoList;
