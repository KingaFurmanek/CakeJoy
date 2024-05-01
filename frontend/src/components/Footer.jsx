// Footer.jsx
import React from 'react';
import './Footer.css'; 
import facebook from '../assets/facebook.svg';
import instagram from '../assets/instagram.svg';
import twitter from '../assets/twitter.svg';

const Footer = () => {
    return (
        <footer className="footer">
            <ul>
                <a>About Us</a>
                <a>Contact</a>
            </ul>
            <div className="media">
                <img src={facebook} alt="Facebook" />
                <img src={instagram} alt="Instagram" />
                <img src={twitter}  alt="Twitter" />
            </div>
        </footer>
    );
}

export default Footer;
