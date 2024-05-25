import React from 'react';
import './MobileFooter.css';
import accountIcon from "../assets/account_media_button.svg"
import {Link} from "react-router-dom";

const MobileBakerFooter = () => {
    return (
        <footer className="media-footer">
            <Link className='media-buttons' to="/account">
                <a className="account-button">
                    <img src={accountIcon} alt="Account" />
                </a>
            </Link>
        </footer>
    );
}

export default MobileBakerFooter;
