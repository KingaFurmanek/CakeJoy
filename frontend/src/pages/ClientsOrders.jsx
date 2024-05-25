import React, { useState, useEffect } from 'react';
import BakerNavbar from '../components/BakerNavbar';
import Footer from '../components/Footer';
import ButtonSign from '../components/ButtonSign';
import PrimaryButton from '../components/PrimaryButton';
import './ClientsOrders.css';
import axios from 'axios';
import MobileBakerFooter from "../components/MobileBakerFooter.jsx";

function ClientsOrders() {
    const [orders, setOrders] = useState([]);

    useEffect(() => {
        axios.get('/api/orders')
            .then(response => {
                setOrders(response.data);
            })
            .catch(error => {
                console.error('Error fetching orders:', error);
            });
    }, []);

    return (
        <div className="con">
            <BakerNavbar/>
            <div className="myOrders-container">
                <div className="quote">
                    <p>Clients Orders</p>
                </div>
                <header>
                    <div className="search-bar">
                        <input type="text" id="searchInput" placeholder="Search orders..."/>
                        <PrimaryButton type="button" color="blue">Search</PrimaryButton>
                    </div>
                </header>
                <hr className="separator"/>
                <div className="orders-container">
                    {orders.map(order => (
                        <div className="order" key={order.id}>
                            <ButtonSign color="lightPink" className="order-detail"
                                        redirectTo={`/clientOrder/${order.id}`}>
                                Order nr: {order.id}, Category: {order.category}
                            </ButtonSign>
                        </div>
                    ))}
                </div>
            </div>
            <Footer/>
            <div className='mobileFooter'>
                <MobileBakerFooter/>
            </div>
        </div>
    );
}

export default ClientsOrders;
