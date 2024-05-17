import React, { useState } from 'react';
import './signUp.css';
import Input from '../components/Input'; // Import komponentu Input
import ButtonSign from '../components/ButtonSign';
import axios from '../../axiosConfig';
import {useNavigate} from "react-router-dom";

const SignUp = () => {
    const [formData, setFormData] = useState({
        name: '',
        surname: '',
        email: '',
        password: '',
        country: '',
        postcode: '',
        city: '',
        street: '',
        number: ''
    });

    const navigate = useNavigate();

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData({
            ...formData,
            [name]: value
        });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const response = await axios.post('/api/auth/register', formData);

            localStorage.setItem('token', response.data.token);
            navigate('/login');
        } catch (error) {
            console.error('Registration failed:', error.response.data);
            alert('Registration failed');
        }
    };

    return (
        <div className="signUp-container">
            <form className="signUpForm" onSubmit={handleSubmit}>
                <Input
                    label="Name"
                    name="name"
                    type="text"
                    id="name"
                    value={formData.name}
                    onChange={handleChange}
                />
                <Input
                    label="Surname"
                    name="surname"
                    type="text"
                    id="surname"
                    value={formData.surname}
                    onChange={handleChange}
                />
                <Input
                    label="Email"
                    name="email"
                    type="email"
                    id="email"
                    value={formData.email}
                    onChange={handleChange}
                />
                <Input
                    label="Password"
                    name="password"
                    type="password"
                    id="password"
                    value={formData.password}
                    onChange={handleChange}
                />
                <Input
                    label="Country"
                    name="country"
                    type="text"
                    id="country"
                    value={formData.country}
                    onChange={handleChange}
                />
                <Input
                    label="Post Code"
                    name="postcode"
                    type="text"
                    id="postcode"
                    value={formData.postcode}
                    onChange={handleChange}
                />
                <Input
                    label="City"
                    name="city"
                    type="text"
                    id="city"
                    value={formData.city}
                    onChange={handleChange}
                />
                <Input
                    label="Street"
                    name="street"
                    type="text"
                    id="street"
                    value={formData.street}
                    onChange={handleChange}
                />
                <Input
                    label="Number"
                    name="number"
                    type="text"
                    id="number"
                    value={formData.number}
                    onChange={handleChange}
                />
                <ButtonSign color="pink" type="submit">Sign up</ButtonSign>
            </form>
        </div>
    );
}

export default SignUp;
