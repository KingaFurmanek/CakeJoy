// OrderTracker.jsx

import React, { useState } from 'react';
import './OrderTracker.css';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faBoxOpen, faTruck, faCheckCircle, faHome } from '@fortawesome/free-solid-svg-icons';

const OrderTracker = () => {
  const [status, setStatus] = useState('In preparation');

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
