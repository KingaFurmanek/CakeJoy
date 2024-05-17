import React from 'react';
import './MobileFooter.css';
import dashboardIcon from "../assets/home_media_button.svg"
import orderIcon from "../assets/order_media_button.svg"
import accountIcon from "../assets/account_media_button.svg"

const MobileFooter = () => {
    return (
        <footer className="media-footer">
            <a className='media-buttons' href="dashboard">
                <button className="home-button">
                    <img src={dashboardIcon} alt="Home" />
                </button>
            </a>
            <a className='media-buttons' href="chooseCategory">
                <button className="order-media-button">
                    <img src={orderIcon} alt="Order" />
                </button>
            </a>
            <a className='media-buttons' href="account">
                <button className="account-button">
                    <img src={accountIcon} alt="Account" />
                </button>
            </a>
        </footer>
    );
}

export default MobileFooter;
