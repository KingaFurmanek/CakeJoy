import React from 'react';
import './ButtonSign.css';

const ButtonSign = ({ color, children, onClick, redirectTo }) => {
  const buttonClassName = `button ${color}`;

  const handleClick = () => {
    if (redirectTo) {
      window.location.href = redirectTo;
    } else if (onClick) {
      onClick();
    }
  };

  return (
    <button className={buttonClassName} onClick={handleClick}>
      {children}
    </button>
  );
}

export default ButtonSign;
