// Checkbox.jsx

import React from 'react';
import './Checkbox.css';

function Checkbox({ id, label, checked, value}) {
  return (
    <label htmlFor={id} className="checkbox">
      <input 
        type="checkbox" 
        id={id} 
        name={id} 
        checked={checked}
        value={value}
      />
      {label}
    </label>
  );
}

export default Checkbox;
