import React, { useEffect, useState } from 'react';
import './RatingComponent.css';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faStar } from '@fortawesome/free-solid-svg-icons';
import axios from '../../axiosConfig';
import { useParams } from "react-router-dom";
import { ToastContainer, toast, Slide } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import Lottie from 'react-lottie';
import submitAnimation from '../animations/submit.json';

const RatingComponent = ({ readonly }) => {
  const [rating, setRating] = useState(0);
  const [hoverValue, setHoverValue] = useState(0);
  const { orderId } = useParams();

  useEffect(() => {
    const fetchRating = async () => {
      try {
        const response = await axios.get(`/api/orders/${orderId}/score`);
        setRating(response.data);
      } catch (error) {
        console.error('Error fetching rating:', error);
      }
    };

    fetchRating();
  }, [orderId]);

  const handleStarClick = async (value) => {
    if (!readonly) {
      try {
        await axios.post(`/api/orders/${orderId}/score`, { score: value });
        setRating(value);
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
              <p>Rating submitted successfully!</p>
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
    }
  };

  const handleMouseOver = (value) => {
    if (!readonly) {
      setHoverValue(value);
    }
  };

  const handleMouseLeave = () => {
    if (!readonly) {
      setHoverValue(0);
    }
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
        <ToastContainer
            transition={Slide}
        />
      </div>
  );
};

export default RatingComponent;
