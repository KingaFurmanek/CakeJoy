import React from 'react';
import Navbar from '../components/Navbar';
import Footer from '../components/Footer';
import PrimaryButton from '../components/PrimaryButton';
import ButtonSign from '../components/ButtonSign';
import './Account.css';
import userImg from '../assets/login.svg';
import axios from "../../axiosConfig.js";
import {useNavigate} from "react-router-dom";

function Account() {

    const navigate = useNavigate();

    const handleLogout = () => {
        window.localStorage.removeItem('token');
        navigate('/login');
    };

    return (
        <div className="con">
            <Navbar />
            <div className="account-container">
                <form action="account" className="login" method="POST" encType="multipart/form-data">
                    <img src={userImg} alt="User Image" />
                    <p>Login</p>
                    <div className="file-label">
                        <input type="file" name="file" />
                    </div>
                </form>
                <div className="data-container">
                    <ButtonSign color="lightPink" redirectTo="/myOrders">My Orders</ButtonSign>
                    <ButtonSign color="lightPink" redirectTo="/myAddress">My Address</ButtonSign>
                    <ButtonSign color="lightPink" onClick={handleLogout}>Log out</ButtonSign>
                </div>
            </div>
            <Footer />
        </div>
    );
}

export default Account;
