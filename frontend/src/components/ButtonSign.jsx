import React from 'react';
import { useNavigate } from 'react-router-dom';
import styles from './ButtonSign.module.css';

const ButtonSign = ({ color, children, onClick, redirectTo }) => {
  const navigate = useNavigate();
  const buttonColor = styles[color] ? styles[color] : styles.default;

  const handleClick = () => {
    if (redirectTo) {
      navigate(redirectTo);
    } else if (onClick) {
      onClick();
    }
  };

  return (
      <button className={`${styles.button} ${buttonColor}`} onClick={handleClick}>
        {children}
      </button>
  );
}

export default ButtonSign;
