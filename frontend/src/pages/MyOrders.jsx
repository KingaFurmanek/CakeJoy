import React, { useState, useEffect } from 'react';
import Navbar from '../components/Navbar';
import Footer from '../components/Footer';
import ButtonSign from '../components/ButtonSign';
import PrimaryButton from '../components/PrimaryButton';
import './MyOrders.css';
import axios from '../../axiosConfig';
import MobileFooter from "../components/MobileFooter.jsx";

function MyOrders() {
    const [orders, setOrders] = useState([]);
    const [searchQuery, setSearchQuery] = useState('');

    useEffect(() => {
        fetchOrders();
    }, []);

    const fetchOrders = async () => {
        try {
            const response = await axios.get('/api/orders/user', {
                headers: {
                    Authorization: `Bearer ${localStorage.getItem('token')}`
                }
            });
            setOrders(response.data);
        } catch (error) {
            console.error('Error fetching orders:', error);
        }
    };

    const handleSearch = async () => {
        if (searchQuery.trim() === '') {
            fetchOrders();
            return;
        }

        try {
            const response = await axios.get(`/api/search?query=${searchQuery}`, {
                headers: {
                    Authorization: `Bearer ${localStorage.getItem('token')}`
                }
            });
            setOrders(response.data);
        } catch (error) {
            console.error('Error searching orders:', error);
        }
    };

    return (
        <div className="con">
            <Navbar/>
            <div className="myOrders-container">
                <div className="quote">
                    <p>My Orders</p>
                </div>
                <header>
                    <div className="search-bar">
                        <input
                            type="text"
                            id="searchInput"
                            placeholder="Search orders..."
                            value={searchQuery}
                            onChange={(e) => setSearchQuery(e.target.value)}
                        />
                        <PrimaryButton type="button" color="blue" onClick={handleSearch}>
                            Search
                        </PrimaryButton>
                    </div>
                </header>
                <hr className="separator"/>
                <div className="orders-container">
                    {orders.map(order => (
                        <div key={order.id} className="order">
                            <ButtonSign color="lightPink" className="order-detail" redirectTo={`/order/${order.id}`}>
                                Order nr: {order.id} - Category: {order.category}
                            </ButtonSign>
                        </div>
                    ))}
                </div>
            </div>
            <Footer/>
            <div className='mobileFooter'>
                <MobileFooter/>
            </div>
        </div>
    );
}

export default MyOrders;
