import React from 'react';
import './BakerNavbar.css'; 
import logo_2 from '../assets/logo_withoutBackground.svg';

const BakerNavbar = () => {
    return (
        <nav className='baker-navbar'>
            <h2>Cake Joy</h2>
            <div className="menu-baker">
                <ul>
                    <a href="clientsOrders">ORDERS</a>
                    <a href="accountBaker">ACCOUNT</a>
                </ul>
                <img className='logo_2' src={logo_2} alt="Logo" />
            </div>
        </nav>
    );
}

export default BakerNavbar;
