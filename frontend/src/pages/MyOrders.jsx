import React from 'react';
import Navbar from '../components/Navbar';
import Footer from '../components/Footer';
import ButtonSign from '../components/ButtonSign';
import PrimaryButton from '../components/PrimaryButton';
import './MyOrders.css'; // Importowanie stylów dla MyOrders

function MyOrders() {
    return (
        <div className="con">
            <Navbar />
            <div className="myOrders-container">
                <div className="quote">
                    <p>My Orders</p>
                </div>
                <header>
                    <div className="search-bar">
                        <input type="text" id="searchInput" placeholder="Search orders..." />
                        <PrimaryButton type="button" color="blue">Search</PrimaryButton>
                    </div>
                </header>
                <hr className="separator" />
                <div className="orders-container">
                    <div className="order">
                        <ButtonSign color="lightPink" className="order-detail" redirectTo="/order">Order nr: - Category: -</ButtonSign>
                    </div>
                </div>
            </div>
            <Footer />
        </div>
    );
}

export default MyOrders;
