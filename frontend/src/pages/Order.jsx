import React, { useState } from 'react';
import Navbar from '../components/Navbar';
import Footer from '../components/Footer';
import ButtonSign from '../components/ButtonSign';
import PrimaryButton from '../components/PrimaryButton';
import './Order.css'; // Importowanie stylów dla MyOrders
import OrderTracker from '../components/OrderTracker';
import RatingComponent from '../components/RatingComponent';

function Order() {
    const [isDelivered, setIsDelivered] = useState(false);

    const handleDelivered = () => {
        setIsDelivered(true);
    };

    return (
        <div className="con">
            <Navbar />
            <div className="order-container">
                <p className='order-number'>Order nr: - Category: -</p>
                <hr className="separator" />
                <div className="description-container">
                    <p>Occasion: -</p>
                    <p>Quantity: -</p>
                    <p>Flavours: -</p>
                    <p>Delivery Date: -</p>
                </div>
                <OrderTracker />
                <RatingComponent/>
            </div>
            <Footer />
        </div>
    );
}

export default Order;
