// Checkbox.jsx

import React from 'react';
import './Checkbox.css';

function Checkbox({ id, label, value, name, checked, onChange}) {
    return (
        <div className="checkbox">
            <input
                type="checkbox"
                id={id}
                value={value}
                name={name}
                checked={checked}
                onChange={onChange}
            />
            <label htmlFor={id}>{label}</label>
        </div>
    );
}

export default Checkbox;
