import React from 'react';
import styles from './ButtonSign.module.css';

const ButtonSign = ({ color, children, onClick, redirectTo }) => {
  // Sprawdzenie, czy kolor istnieje w stylach, jeśli nie, użyj domyślnego koloru
  const buttonColor = styles[color] ? styles[color] : styles.default;

  const handleClick = () => {
    if (redirectTo) {
      window.location.href = redirectTo;
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
