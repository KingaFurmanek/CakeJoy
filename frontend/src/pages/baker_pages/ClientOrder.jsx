import React, { useEffect, useState } from 'react';
import BakerNavbar from '../../components/BakerNavbar.jsx';
import Footer from '../../components/Footer.jsx';
import './ClientOrder.css';
import PrimaryButton from '../../components/PrimaryButton.jsx';
import { useParams } from "react-router-dom";
import axios from "../../../axiosConfig.js";
import {ToastContainer, toast, Slide} from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import Lottie from 'react-lottie';
import submitAnimation from '../../animations/submit.json';
import MobileBakerFooter from "../../components/MobileBakerFooter.jsx";

function Order() {
    const [status, setStatus] = useState('In preparation');
    const [order, setOrder] = useState(null);
    const { orderId } = useParams();

    const handleStatusChange = (event) => {
        setStatus(event.target.value);
    };

    const handleSubmit = async () => {
        try {
            await axios.post(`/api/orders/${orderId}/state`, { state: status });
            toast.success(
                <div className="submit-toast">
                    <Lottie
                        options={{
                            loop: false,
                            autoplay: true,
                            animationData: submitAnimation,
                            rendererSettings: {
                                preserveAspectRatio: 'xMidYMid slice'
                            }
                        }}
                        height={90}
                        width={90}
                    />
                    <p>Status submitted successfully!</p>
                </div>,
                {
                    position: "top-center",
                    autoClose: 5000,
                    hideProgressBar: true,
                    closeOnClick: true,
                    pauseOnHover: true,
                    draggable: true,
                    progress: undefined,
                    className: 'toast-message',
                }
            );
        } catch (error) {
            console.error('Error submitting rating:', error);
            toast.error('Error submitting rating', {
                position: "top-center",
                autoClose: 3000,
                hideProgressBar: true,
                closeOnClick: true,
                pauseOnHover: true,
                draggable: true,
                progress: undefined,
                className: 'toast-message',
            });
        }
    };

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
            <BakerNavbar/>
            <div className="order-container">
                {order && (
                    <>
                        <p className='order-number'>Order nr: {order.id}, Category: {order.category}</p>
                        <hr className="separator"/>
                        <div className="description-container">
                            {order.occasion && <p>Occasion: {order.occasion}</p>}
                            <p>Quantity: {order.quantity}</p>
                            {order.flavours.length > 0 && <p>Flavours: {order.flavours.join(', ')}</p>}
                            <p>Delivery Date: {order.date}</p>
                            <p>Additional Info: {order.additionalInfo}</p>
                            <p>Colours: {order.colours}</p>
                            {order.tiers && <p>Tiers: {order.tiers}</p>}
                            {order.state && <p>State: {order.state}</p>}
                            {order.score && <p>Score: {order.score}</p>}
                            {order.additionalOptions.length > 0 &&
                                <p>Additional Options: {order.additionalOptions.join(', ')}</p>}
                            {order.glazes.length > 0 && <p>Glazes: {order.glazes.join(', ')}</p>}
                            {order.decorations.length > 0 && <p>Decorations: {order.decorations.join(', ')}</p>}
                            {order.sprinkles.length > 0 && <p>Sprinkles: {order.sprinkles.join(', ')}</p>}
                        </div>

                        <div className="dropdown-menu">
                            <label htmlFor="status">Select status:</label>
                            <select id="status" value={status} onChange={handleStatusChange}>
                                <option className="option-status" value="In preparation">In preparation</option>
                                <option className="option-status" value="Done">Done</option>
                                <option className="option-status" value="Shipped">Shipped</option>
                                <option className="option-status" value="Delivered">Delivered</option>
                            </select>
                            <PrimaryButton color="blue" onClick={handleSubmit}>Submit</PrimaryButton>
                        </div>
                    </>
                )}
            </div>
            <Footer/>
            <ToastContainer
                transition={Slide}
            />
            <div className='mobileFooter'>
                <MobileBakerFooter/>
            </div>
        </div>
    );
}

export default Order;
