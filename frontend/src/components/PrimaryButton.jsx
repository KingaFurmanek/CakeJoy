import React from 'react';
import { useNavigate } from 'react-router-dom';
import styles from './PrimaryButton.module.css';

const PrimaryButton = ({ color, children, onClick, redirectTo }) => {
    const navigate = useNavigate();
    const buttonClassName = `${styles.button} ${styles[color]}`;

    const handleClick = () => {
        if (redirectTo) {
            navigate(redirectTo);
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
