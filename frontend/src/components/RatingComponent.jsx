// RatingComponent.jsx

import React, { useState } from 'react';
import './RatingComponent.css';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faStar } from '@fortawesome/free-solid-svg-icons';

const RatingComponent = ({ initialValue, readonly }) => {
  const [rating, setRating] = useState(initialValue);
  const [hoverValue, setHoverValue] = useState(0);

  const handleStarClick = (value) => {
    if (!readonly) {
      setRating(value);
    }
  };

  const handleMouseOver = (value) => {
    if (!readonly) {
      setHoverValue(value);
    }
  };

  const handleMouseLeave = () => {
    setHoverValue(0);
  };

  return (
    <div className="rating">
      {[1, 2, 3, 4, 5].map((index) => (
        <FontAwesomeIcon
          key={index}
          icon={faStar}
          className="star"
          style={{
            color: index <= (hoverValue || rating) ? "#FFD700" : "#BDBDBD",
            fontSize: "50px"
          }}
          onClick={() => handleStarClick(index)}
          onMouseOver={() => handleMouseOver(index)}
          onMouseLeave={handleMouseLeave}
        />
      ))}
    </div>
  );
};

export default RatingComponent;
