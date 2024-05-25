import React from 'react';
import './MobileFooter.css';
import dashboardIcon from "../assets/home_media_button.svg"
import orderIcon from "../assets/order_media_button.svg"
import accountIcon from "../assets/account_media_button.svg"
import {Link} from "react-router-dom";

const MobileFooter = () => {
    return (
        <footer className="media-footer">
            <Link className='media-buttons' to="/dashboard">
                <a className="home-button">
                    <img src={dashboardIcon} alt="Home" />
                </a>
            </Link>
            <Link className='media-buttons' to="/chooseCategory">
                <a className="order-media-button">
                    <img src={orderIcon} alt="Order" />
                </a>
            </Link>
            <Link className='media-buttons' to="/account">
                <a className="account-button">
                    <img src={accountIcon} alt="Account" />
                </a>
            </Link>
        </footer>
    );
}

export default MobileFooter;
