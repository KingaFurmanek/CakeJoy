import React from 'react';
import Navbar from '../components/Navbar';
import Footer from '../components/Footer';
import PrimaryButton from '../components/PrimaryButton';
import './Success.css';
import success from '../assets/success.svg';

function Success() {

    return (
        <div className="con">
            <Navbar />
            <div className="cont2">
                <div className="success-container">
                    <div className="success-img">
                        <img src={success} alt="Success" />
                    </div>
                    <div className="text">
                        <p>
                            Thank you for your order!<br /><br />
                            Your order has been placed.<br />
                            You will receive an email shortly<br /> to confirm the details.<br /><br />
                            If you have any questions feel free to <br />reach out to us at <br /><br />
                            <a href="mailto:cakejoy@gmail.com">cakejoy@gmail.com</a> <br />
                            or <br />
                            +48 111 222 333
                        </p>
                    </div>
                </div>
                <PrimaryButton type="button" color="blue" redirectTo="/dashboard">Done</PrimaryButton>
            </div>
            <Footer />
        </div>
    );
}

export default Success;
