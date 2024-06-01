import React from 'react';
import { Link } from 'react-router-dom';
import './Navbar.css';
import logo_2 from '../assets/logo_withoutBackground.svg';

const Navbar = () => {
    return (
        <nav className='navbar'>
            <h2>Cake Joy</h2>
            <div className="menu">
                <ul>
                    <li><Link to="/dashboard">HOME</Link></li>
                    <li><Link to="/chooseCategory">ORDER</Link></li>
                    <li><Link to="/account">ACCOUNT</Link></li>
                </ul>
                <img className='logo_2' src={logo_2} alt="Logo" />
            </div>
        </nav>
    );
}

export default Navbar;
