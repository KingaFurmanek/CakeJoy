import React from 'react';
import './BakerNavbar.css'; 
import logo_2 from '../assets/logo_withoutBackground.svg';
import {Link} from "react-router-dom";

const BakerNavbar = () => {
    return (
        <nav className='baker-navbar'>
            <h2>Cake Joy</h2>
            <div className="menu-baker">
                <ul>
                    <li><Link to="/clientsOrders">ORDERS</Link></li>
                    <li><Link to="/accountBaker">ACCOUNT</Link></li>
                </ul>
                <img className='logo_2' src={logo_2} alt="Logo" />
            </div>
        </nav>
    );
}

export default BakerNavbar;
