import React, { useState } from 'react';

function UserForm({ onAddUser }) {
  const [name, setName] = useState('');
  const [email, setEmail] = useState('');

  const submit = (e) => {
    e.preventDefault();
    onAddUser({ name, email });
    setName('');
    setEmail('');
  };

  return (
    <form onSubmit={submit} className="user-form">
      <h3>Add User</h3>
      <input value={name} onChange={(e) => setName(e.target.value)} placeholder="Name" required />
      <input value={email} onChange={(e) => setEmail(e.target.value)} placeholder="Email" required />
      <button type="submit">Add User</button>
    </form>
  );
}

export default UserForm;
