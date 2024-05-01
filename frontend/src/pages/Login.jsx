import React from 'react';
import '../components/ButtonSign.css'; // Import styl dla przycisków
import '../components/Input.css'; // Import styl dla pola wejściowego
import ButtonSign from '../components/ButtonSign'; // Importuj komponent ButtonSign
import Input from '../components/Input'; // Importuj komponent Input
import './login.css';
import logo from '../assets/logo.svg';

const LoginPage = () => {
  return (
    <div className="container">
      <div className="logo">
        <img src={logo} alt="Logo" />
      </div>
      <div className="login-container">
        <form className="loginForm" action="login" method="POST">
          <Input label="Email" name="email" type="text" />
          <Input label="Password" name="password" type="password" />
          <ButtonSign type="submit" color="pink">Log in</ButtonSign>
          <a href="/signUp" className="sign-up">Sign up</a>
        </form>
      </div>
    </div>
  );
}

export default LoginPage;
