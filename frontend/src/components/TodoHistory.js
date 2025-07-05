import React, { useEffect, useState } from 'react';
import axios from 'axios';

function TodoHistory({ todoId }) {
  const [history, setHistory] = useState([]);

  useEffect(() => {
    axios.get(`http://localhost:8080/api/todo-history/todo/${todoId}`)
      .then(res => setHistory(res.data))
      .catch(err => console.error('Error loading history:', err));
  }, [todoId]);

  return (
    <div className="todo-history">
      {history.length === 0 ? (
        <p>No history found.</p>
      ) : (
        <ul>
          {history.map(entry => (
            <li key={entry.historyId}>
              [{new Date(entry.timestamp).toLocaleString()}] {entry.action}
              {entry.user && ` by ${entry.user.email}`}
            </li>
          ))}
        </ul>
      )}
    </div>
  );
}

export default TodoHistory;
