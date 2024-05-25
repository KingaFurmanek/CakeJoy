import React from 'react';
import Footer from '../components/Footer';
import ButtonSign from '../components/ButtonSign';
import './AccountBaker.css';
import userImg from '../assets/login.svg';
import BakerNavbar from '../components/BakerNavbar';
import {useNavigate} from "react-router-dom";
import MobileFooter from "../components/MobileFooter.jsx";
import MobileBakerFooter from "../components/MobileBakerFooter.jsx";

function AccountBaker() {
    const navigate = useNavigate();

    const handleLogout = () => {
        window.localStorage.removeItem('token');
        navigate('/login');
    };

    return (
        <div className="con">
            <BakerNavbar/>
            <div className="account-container">
                <form action="account" className="login" method="POST" encType="multipart/form-data">
                    <img src={userImg} alt="User Image"/>
                    <p>Baker</p>
                    <div className="file-label">
                        <input type="file" name="file"/>
                    </div>
                </form>
                <div className="data-container-baker">
                    <ButtonSign color="lightPink" redirectTo="/clientsOrders">Clients Orders</ButtonSign>
                    <ButtonSign color="lightPink" onClick={handleLogout}>Log out</ButtonSign>
                </div>
            </div>
            <Footer/>
            <div className='mobileFooter'>
                <MobileBakerFooter/>
            </div>
        </div>
    );
}

export default AccountBaker;
