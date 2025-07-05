import React from 'react';

function UserDropdown({ users, onAssign }) {
  return (
    <select onChange={(e) => onAssign(e.target.value)} defaultValue="">
      <option value="" disabled>Assign to user</option>
      {users.map(user => (
        <option key={user.userId} value={user.userId}>
          {user.name} ({user.email})
        </option>
      ))}
    </select>
  );
}

export default UserDropdown;
