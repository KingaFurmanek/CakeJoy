import React, { useEffect, useState } from 'react';
import './Forms.css';
import Input from '../../components/Input';
import Navbar from '../../components/Navbar';
import Footer from '../../components/Footer';
import PrimaryButton from '../../components/PrimaryButton';
import Checkbox from '../../components/Checkbox';
import { useCategory } from '../../components/CategoryContext.jsx';
import axios from '../../../axiosConfig';
import MobileFooter from "../../components/MobileFooter.jsx";
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";
import {useNavigate} from "react-router-dom";

function CookieForm() {
    const { chosenCategory } = useCategory();
    const navigate = useNavigate();
    const [formData, setFormData] = useState({
        quantity: '',
        flavours: [],
        colours: '',
        additionalOptions: [],
        date: '',
        additionalInfo: '',
        userId: '',
        category: chosenCategory
    });

    const handleSubmit = async (e) => {
        e.preventDefault();
        if (!validateForm()) {
            alert('Please fill out all fields');
            return;
        }
        try {
            const response = await axios.post('/api/orders/submit', formData, {
                headers: {
                    Authorization: `Bearer ${localStorage.getItem('token')}`
                }
            });
            console.log('Order submitted successfully:', response.data);
            navigate('/success');
        } catch (error) {
            console.error('Error submitting order:', error);
        }
    };

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData({ ...formData, [name]: value });
    };

    const handleCheckboxChange = (e) => {
        const { name, checked, value } = e.target;
        let updatedArray = [];
        if (checked) {
            if (formData[name].length < (name === 'flavours' ? 3 : 2)) {
                updatedArray = [...formData[name], value];
            } else {
                alert(`You can select maximum ${name === 'flavours' ? '3' : '2'} ${name}`);
                return;
            }
        } else {
            updatedArray = formData[name].filter((item) => item !== value);
        }

        setFormData({ ...formData, [name]: updatedArray });
    };

    const validateForm = () => {
        const { quantity,flavours, colours, additionalOptions, date, additionalInfo } = formData;
        return !(!quantity || !colours || !date || !additionalOptions.length || !flavours.length || !additionalInfo);

    };

    return (
        <div className="con">
            <Navbar />
            <div className="form-container">
                <form className="form-details" onSubmit={handleSubmit}>
                    <Input label="Quantity (kg)" name="quantity" type="number" id="quantity" value={formData.quantity}
                           onChange={handleChange}/>
                    <p> Filling Type (max. 3)</p>
                    <div className="custom-checkboxes">
                        <Checkbox id="chocolate" label="Chocolate" value="chocolate" name="flavours"
                                  checked={formData.flavours.includes('chocolate')} onChange={handleCheckboxChange}/>
                        <Checkbox id="strawberry" label="Strawberry" value="strawberry" name="flavours"
                                  checked={formData.flavours.includes('strawberry')} onChange={handleCheckboxChange}/>
                        <Checkbox id="banana" label="Banana" value="banana" name="flavours"
                                  checked={formData.flavours.includes('banana')} onChange={handleCheckboxChange}/>
                        <Checkbox id="nutella" label="Nutella" value="nutella" name="flavours"
                                  checked={formData.flavours.includes('nutella')} onChange={handleCheckboxChange}/>
                        <Checkbox id="lemon" label="Lemon" value="lemon" name="flavours"
                                  checked={formData.flavours.includes('lemon')} onChange={handleCheckboxChange}/>
                        <Checkbox id="coconut" label="Coconut" value="coconut" name="flavours"
                                  checked={formData.flavours.includes('coconut')} onChange={handleCheckboxChange}/>
                        <Checkbox id="caramel" label="Caramel" value="caramel" name="flavours"
                                  checked={formData.flavours.includes('caramel')} onChange={handleCheckboxChange}/>
                        <Checkbox id="blueberry" label="Blueberry" value="blueberry" name="flavours"
                                  checked={formData.flavours.includes('blueberry')} onChange={handleCheckboxChange}/>
                        <Checkbox id="almond" label="Almond" value="almond" name="flavours"
                                  checked={formData.flavours.includes('almond')} onChange={handleCheckboxChange}/>
                        <Checkbox id="raspberry" label="Raspberry" value="raspberry" name="flavours"
                                  checked={formData.flavours.includes('raspberry')} onChange={handleCheckboxChange}/>
                        <Checkbox id="cherry" label="Cherry" value="cherry" name="flavours"
                                  checked={formData.flavours.includes('cherry')} onChange={handleCheckboxChange}/>
                        <Checkbox id="vanilla" label="Vanilla" value="vanilla" name="flavours"
                                  checked={formData.flavours.includes('vanilla')} onChange={handleCheckboxChange}/>
                    </div>
                    <Input label="Main Colors" name="colours" type="text" id="colours" value={formData.colours}
                           onChange={handleChange}/>
                    <p>Additional Options</p>
                    <div className="custom-checkboxes">
                        <Checkbox id="icing" label="Icing" value="icing" name="additionalOptions"
                                  checked={formData.additionalOptions.includes('icing')}
                                  onChange={handleCheckboxChange}/>
                        <Checkbox id="powdered sugar" label="Powdered Sugar" value="powdered sugar"
                                  name="additionalOptions"
                                  checked={formData.additionalOptions.includes('powdered sugar')}
                                  onChange={handleCheckboxChange}/>
                        <Checkbox id="none" label="None" value="none" name="additionalOptions"
                                  checked={formData.additionalOptions.includes('none')}
                                  onChange={handleCheckboxChange}/>
                    </div>
                    <div className="input-container">
                        <label className="input-label" htmlFor="deliveryDate">Delivery Date</label>
                        <DatePicker
                            selected={formData.date}
                            onChange={(date) => setFormData({...formData, date})}
                            dateFormat="yyyy/MM/dd"
                            className='input-field'
                        />
                    </div>
                    <Input label="Additional Info" name="additionalInfo" type="text" id="additionalInfo"
                           value={formData.additionalInfo} onChange={handleChange}/>
                    <PrimaryButton type="submit" color="blue">Next</PrimaryButton>
                </form>
                <Footer/>
                <div className='mobileFooter'>
                    <MobileFooter/>
                </div>
            </div>
        </div>
    );
}

export default CookieForm;
