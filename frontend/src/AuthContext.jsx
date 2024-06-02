import React, { createContext, useState, useEffect } from 'react';

export const AuthContext = createContext();

export const AuthProvider = ({ children }) => {
    const [isLoggedIn, setIsLoggedIn] = useState(localStorage.getItem('isLoggedIn') === 'true');
    const [userRole, setUserRole] = useState(localStorage.getItem('userRole') || '');

    useEffect(() => {
        const token = localStorage.getItem('token');
        const loggedIn = localStorage.getItem('isLoggedIn') === 'true';
        const role = localStorage.getItem('userRole');

        if (token && loggedIn && role) {
            setIsLoggedIn(loggedIn);
            setUserRole(role);
        }
    }, []);

    return (
        <AuthContext.Provider value={{ isLoggedIn, setIsLoggedIn, userRole, setUserRole }}>
            {children}
        </AuthContext.Provider>
    );
};
