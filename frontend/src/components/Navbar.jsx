import React from 'react';
import './Navbar.css'; 
import logo_2 from '../assets/logo_withoutBackground.svg';

const Navbar = () => {
    return (
        <nav className='navbar'>
            <h2>Cake Joy</h2>
            <div className="menu">
                <ul>
                    <a href="dashboard">HOME</a>
                    <a href="chooseCategory">ORDER</a>
                    <a href="account">ACCOUNT</a>
                </ul>
                <img className='logo_2' src={logo_2} alt="Logo" />
            </div>
        </nav>
    );
}

export default Navbar;
