import React, { useState } from 'react';
import BakerNavbar from '../components/BakerNavbar';
import Footer from '../components/Footer';
import './ClientOrder.css'; // Importowanie stylów dla ClientOrder
import PrimaryButton from '../components/PrimaryButton';
import OrderTracker from '../components/OrderTracker';

function Order() {
    const [status, setStatus] = useState('In preperation');

    const handleStatusChange = (event) => {
        setStatus(event.target.value);
    };

    const handleSubmit = () => {
        console.log('Status:', status);
    };

    return (
        <div className="con">
            <BakerNavbar />
            <div className="order-container">
                <p className='order-number'>Order nr: - Category: -</p>
                <hr className="separator"/>
                <div className="dropdown-container">
                    <div className="description-container">
                        <p>Occasion: -</p>
                        <p>Quantity: -</p>
                        <p>Flavours: -</p>
                        <p>Delivery Date: -</p>
                        <p>Delivery Date: -</p>
                        <p>Delivery Date: -</p>
                        <p>Delivery Date: -</p>
                    </div>

                    <div className="dropdown-menu">
                        <label htmlFor="status">Select status:</label>
                        <select id="status" value={status} onChange={handleStatusChange}>
                            <option value="In preperation">In preparation</option>
                            <option value="Done">Done</option>
                            <option value="Shipped">Shipped</option>
                            <option value="Delivered">Delivered</option>
                        </select>
                        <PrimaryButton color="blue" onClick={handleSubmit}>Submit</PrimaryButton>
                    </div>
                </div>
            </div>
            <Footer/>
        </div>
    );
}

export default Order;
