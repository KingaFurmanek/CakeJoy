import React, { useState, useContext } from 'react';
import axios from '../../axiosConfig';
import ButtonSign from '../components/ButtonSign';
import Input from '../components/Input';
import './login.css';
import logo from '../assets/logo.svg';
import { useNavigate } from 'react-router-dom';
import { AuthContext } from '../AuthContext.jsx';

const LoginPage = () => {
    const [error, setError] = useState('');
    const navigate = useNavigate();

    const { setIsLoggedIn, setUserRole } = useContext(AuthContext);

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
            localStorage.setItem('isLoggedIn', true);
            localStorage.setItem('userRole', response.data.role);
            setIsLoggedIn(localStorage.getItem('isLoggedIn') === 'true');
            setUserRole(response.data.role);
            if (response.data.role === 'baker') {
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
