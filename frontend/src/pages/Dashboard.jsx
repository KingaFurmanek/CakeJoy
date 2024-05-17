import React, {useEffect, useState} from 'react';
import Navbar from '../components/Navbar';
import Footer from '../components/Footer';
import PrimaryButton from '../components/PrimaryButton';
import './dashboard.css'
import step1 from '../assets/step1.svg';
import step2 from '../assets/step2.svg';
import step3 from '../assets/step3.svg';
import step4 from '../assets/step4.svg';
import step5 from '../assets/step5.svg';
import MobileFooter from '../components/MobileFooter';
import axios from '../../axiosConfig';

const Dashboard = () => {
    const [userName, setUserName] = useState('');
    useEffect(() => {

        const fetchUserData = async () => {
            try {
                const response = await axios.get('/api/users/info', {
                    headers: {
                        Authorization: `Bearer ${localStorage.getItem('token')}`
                    }
                });
                setUserName(response.data.name);
            } catch (error) {
                console.error('Error fetching user data:', error);
            }
        };
        fetchUserData();
    }, []);

    return (
            <div className="con">
                <Navbar/>
                <main className='dashboard-container'>
                    <div className="hello-quote">
                        <h1>Hello {userName}!</h1>
                        <h2>Ordering made simple - just a few clicks away!</h2>
                    </div>

                    <div className="ordering-container" style={{textAlign: 'center'}}>
                        <div className="step1">
                            <img src={step1} alt="Step 1"/>
                            <p>Choose Category</p>
                        </div>
                        <div className="step2">
                            <img src={step2} alt="Step 2"/>
                            <p>Fill out the Form</p>
                        </div>
                        <div className="step3">
                            <img src={step3} alt="Step 3"/>
                            <p>Await Email</p>
                        </div>
                        <div className="step4">
                            <img src={step4} alt="Step 4"/>
                            <p>Wait for Delivery</p>
                        </div>
                        <div className="step5">
                            <img src={step5} alt="Step 5"/>
                            <p>Enjoy Your Order</p>
                        </div>
                    </div>
                    <PrimaryButton type="submit" color="blue" redirectTo="/chooseCategory">Order</PrimaryButton>
                    <Footer/>
                    <div className='mobileFooter'>
                        <MobileFooter/>
                    </div>
                </main>
            </div>
        );
}
export default Dashboard;
