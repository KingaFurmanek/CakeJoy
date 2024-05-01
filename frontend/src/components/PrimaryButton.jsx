import React from 'react';
import styles from './PrimaryButton.module.css';

const PrimaryButton = ({ color, children, onClick, redirectTo }) => {
    const buttonClassName = `${styles.button} ${styles[color]}`;

    const handleClick = () => {
        if (redirectTo) {
            // Jeśli używasz React Router
            // this.props.history.push(redirectTo);
            // Jeśli nie używasz React Router
            window.location.href = redirectTo;
        } else if (onClick) {
            // Jeśli onClick jest zdefiniowany, wywołaj tę funkcję
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
