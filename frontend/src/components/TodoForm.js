import React, { useState } from 'react';

function TodoForm({ onAdd }) {
  const [title, setTitle] = useState('');
  const [listItems, setListItems] = useState('');
  const [status, setStatus] = useState('Pending');
  const [isActive, setIsActive] = useState(true);

  const handleSubmit = (e) => {
    e.preventDefault();
    const todo = {
      title: title.trim(),
      listOfItems: listItems.split(',').map(i => i.trim()).filter(Boolean),
      status,
      isActive
    };
    onAdd(todo);
    setTitle('');
    setListItems('');
    setStatus('Pending');
    setIsActive(true);
  };

  return (
    <form onSubmit={handleSubmit} className="todo-form">
      <input value={title} onChange={(e) => setTitle(e.target.value)} placeholder="Title" required />
      <input value={listItems} onChange={(e) => setListItems(e.target.value)} placeholder="Items (comma-separated)" />
      <select value={status} onChange={(e) => setStatus(e.target.value)}>
        <option value="Pending">Pending</option>
        <option value="Completed">Completed</option>
      </select>
      <label>
        <input type="checkbox" checked={isActive} onChange={() => setIsActive(!isActive)} />
        Active
      </label>
      <button type="submit">Add Todo</button>
    </form>
  );
}

export default TodoForm;
