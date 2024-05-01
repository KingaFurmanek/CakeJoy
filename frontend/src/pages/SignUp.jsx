import React, { useState } from 'react';
import './signUp.css';
import Input from '../components/Input'; // Import komponentu Input
import ButtonSign from '../components/ButtonSign';

const SignUp = () => {
    return (
        <div className="signUp-container">
            <form className="signUpForm">
                <Input
                    label="Name"
                    name="name"
                    type="text"
                    id="name" 
                />
                <Input
                    label="Surname"
                    name="surname"
                    type="text"
                    id="surname" 
                />
                <Input
                    label="Email"
                    name="email"
                    type="text"
                    id="email" 
                />
                <Input
                    label="Password"
                    name="password"
                    type="text"
                    id="password" 
                />
                <Input
                    label="Country"
                    name="country"
                    type="text"
                    id="country" 
                />
                <Input
                    label="Post Code"
                    name="postcode"
                    type="text"
                    id="postcode" 
                />
                <Input
                    label="City"
                    name="city"
                    type="text"
                    id="city" 
                />
                <Input
                    label="Street"
                    name="street"
                    type="text"
                    id="street" 
                />
                <Input
                    label="Number"
                    name="number"
                    type="text"
                    id="number" 
                />
                <ButtonSign color="pink">Sign up</ButtonSign>
            </form>
        </div>
    );
}


export default SignUp;