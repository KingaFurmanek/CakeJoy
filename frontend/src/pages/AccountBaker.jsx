import React from 'react';
import Footer from '../components/Footer';
import PrimaryButton from '../components/PrimaryButton';
import ButtonSign from '../components/ButtonSign';
import './AccountBaker.css';
import userImg from '../assets/login.svg';
import BakerNavbar from '../components/BakerNavbar';

function AccountBaker() {
    return (
        <div className="con">
            <BakerNavbar/>
            <div className="account-container">
                <form action="account" className="login" method="POST" encType="multipart/form-data">
                    <img src={userImg} alt="User Image" />
                    <p>Baker</p>
                    <div className="file-label">
                        <input type="file" name="file" />
                    </div>
                </form>
                <div className="data-container-baker">
                    <ButtonSign color="lightPink" redirectTo="/clientsOrders">Clients Orders</ButtonSign>
                    <ButtonSign color="lightPink" >Log out</ButtonSign>
                </div>
            </div>
            <Footer />
        </div>
    );
}

export default AccountBaker;
