import React, { useState, useEffect } from 'react';
import axios from '../../axiosConfig';
import ButtonSign from '../components/ButtonSign';
import Input from '../components/Input';
import './login.css';
import logo from '../assets/logo.svg';
import { useNavigate } from 'react-router-dom';

const LoginPage = () => {
    const [error, setError] = useState('');
    const navigate = useNavigate();

    const [formData, setFormData] = useState({
        email: '',
        password: '',
    });

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData({
            ...formData,
            [name]: value
        });
    };

    const handleLogin = async (e) => {
        e.preventDefault();
        try {
            const response = await axios.post('/api/auth/login', formData);
            localStorage.setItem('token', response.data.token);
            console.log(response.data);
            // Dodaj przekierowanie na odpowiednią stronę na podstawie roli użytkownika
            const userRole = response.data.role;
            if (userRole === 'baker') {
                navigate("/clientsOrders");
            } else {
                navigate("/dashboard");
            }
        } catch (error) {
            console.error('Login error:', error);
            setError('Invalid email or password');
        }
    };

    return (
        <div className="container">
            <div className="logo">
                <img src={logo} alt="Logo" />
            </div>
            <div className="login-container">
                <form className="loginForm" onSubmit={handleLogin}>
                    <Input label="Email" name="email" type="text" value={formData.email} onChange={handleChange} />
                    <Input label="Password" name="password" type="password" value={formData.password} onChange={handleChange} />
                    <ButtonSign type="submit" color="pink">Log in</ButtonSign>
                    {error && <p className="error-message">{error}</p>}
                    <a href="/signUp" className="sign-up">Sign up</a>
                </form>
            </div>
        </div>
    );
};

export default LoginPage;
