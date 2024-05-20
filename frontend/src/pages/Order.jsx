import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import Navbar from '../components/Navbar';
import Footer from '../components/Footer';
import './Order.css'; // Importowanie stylów dla MyOrders
import OrderTracker from '../components/OrderTracker';
import RatingComponent from '../components/RatingComponent';
import axios from '../../axiosConfig';

function Order({ match }) {
    const [order, setOrder] = useState(null);
    const {orderId} = useParams();

    useEffect(() => {
        const fetchOrderDetails = async () => {
            try {
                const response = await axios.get(`/api/orders/${orderId}`);
                setOrder(response.data);
            } catch (error) {
                console.error('Error fetching order details:', error);
            }
        };

        fetchOrderDetails();
    }, [orderId]);

    return (
        <div className="con">
            <Navbar />
            <div className="order-container">
                {order && (
                    <>
                        <p className='order-number'>Order nr: {order.id},  Category: {order.category}</p>
                        <hr className="separator" />
                        <div className="description-container">
                            {order.occasion && <p>Occasion: {order.occasion}</p>}
                            <p>Quantity: {order.quantity}</p>
                            {order.flavours.length > 0 && <p>Flavours: {order.flavours.join(', ')}</p>}
                            <p>Delivery Date: {order.date}</p>
                            <p>Additional Info: {order.additionalInfo}</p>
                            <p>Colours: {order.colours}</p>
                            {order.tiers && <p>Tiers: {order.tiers}</p>}
                            {order.additionalOptions.length > 0 && <p>Additional Options: {order.additionalOptions.join(', ')}</p>}
                            {order.glazes.length > 0 && <p>Glazes: {order.glazes.join(', ')}</p>}
                            {order.decorations.length > 0 && <p>Decorations: {order.decorations.join(', ')}</p>}
                            {order.sprinkles.length > 0 && <p>Sprinkles: {order.sprinkles.join(', ')}</p>}
                        </div>
                        <OrderTracker />
                        <RatingComponent />
                    </>
                )}
            </div>
            <Footer />
        </div>
    );
}

export default Order;
