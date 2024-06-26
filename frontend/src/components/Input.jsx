import React from 'react';
import './Input.css';

function Input({ label, name, type, value, id, placeholder, onChange }) {
    const handleChange = (e) => {
        onChange(e);
    };

    return (
        <div className="input-container">
            <label className="input-label" htmlFor={id}>{label}</label>
            <input
                className="input-field"
                id={id}
                name={name}
                type={type}
                value={value}
                placeholder={placeholder}
                onChange={handleChange}
            />
        </div>
    );
}

export default Input;
