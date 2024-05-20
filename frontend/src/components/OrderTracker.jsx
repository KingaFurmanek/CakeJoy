import React, { useEffect, useState } from 'react';
import './OrderTracker.css';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faBoxOpen, faTruck, faCheckCircle, faHome } from '@fortawesome/free-solid-svg-icons';
import axios from '../../axiosConfig';
import {useParams} from "react-router-dom";

const OrderTracker = ({ match }) => {
  const [status, setStatus] = useState('');
  const {orderId} = useParams();

  useEffect(() => {
    const fetchOrderStatus = async () => {
      try {
        const response = await axios.get(`/api/orders/${orderId}/state`);
        setStatus(response.data);
      } catch (error) {
        console.error('Error fetching order status:', error);
      }
    };

    fetchOrderStatus();
  }, [orderId]);

  const handleStatusChange = (newStatus) => {
    setStatus(newStatus);
  };

  return (
      <div className="order-tracker">
        <div className="progress-bar">
          <div className={`progress-item ${status === 'In preparation' ? 'active' : ''}`}>
            <FontAwesomeIcon icon={faBoxOpen} />
            <p>In preparation</p>
          </div>
          <div className="progress-line"></div>
          <div className={`progress-item ${status === 'Done' ? 'active' : ''}`}>
            <FontAwesomeIcon icon={faCheckCircle} />
            <p>Done</p>
          </div>
          <div className="progress-line"></div>
          <div className={`progress-item ${status === 'Shipped' ? 'active' : ''}`}>
            <FontAwesomeIcon icon={faTruck} />
            <p>Shipped</p>
          </div>
          <div className="progress-line"></div>
          <div className={`progress-item ${status === 'Delivered' ? 'active' : ''}`}>
            <FontAwesomeIcon icon={faHome} />
            <p>Delivered</p>
          </div>
        </div>
      </div>
  );
};

export default OrderTracker;
