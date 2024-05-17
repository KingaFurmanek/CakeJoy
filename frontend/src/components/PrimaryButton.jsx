import React from 'react';
import styles from './PrimaryButton.module.css';

const PrimaryButton = ({ color, children, onClick, redirectTo }) => {
    const buttonClassName = `${styles.button} ${styles[color]}`;

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

export default PrimaryButton;
