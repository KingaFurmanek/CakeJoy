import React from 'react';
import Navbar from '../components/Navbar';
import Footer from '../components/Footer';
import PrimaryButton from '../components/PrimaryButton';
import CategoryItem from '../components/CategoryItem';
import './ChooseCategory.css';
import cupcakes from '../assets/cupcakes_category.svg';
import cake from '../assets/cake_category.svg';
import donuts from '../assets/donuts_category.svg';
import cookies from '../assets/cookies_category.svg';
import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { useCategory } from '../components/CategoryContext';

const ChooseCategory = () => {
    const { setChosenCategory } = useCategory();
    const navigate = useNavigate();
    const [chosenCategory, setChosenCategoryLocally] = useState('');

    const handleCategorySelection = (category) => {
        setChosenCategoryLocally(category);
    };

    const handleNextClick = () => {
        setChosenCategory(chosenCategory);
        navigate(`/${chosenCategory}Form`);
    };

    return (
        <div className="con">
            <Navbar />
            <main className="chooseCategory-container">
                <h1 className="quote">Choose category</h1>
                <div className="category-container" id="category-container">
                    <CategoryItem imgSrc={cupcakes} text="Cupcakes" onCategorySelect={handleCategorySelection} />
                    <CategoryItem imgSrc={cake} text="Cakes" onCategorySelect={handleCategorySelection} />
                    <CategoryItem imgSrc={donuts} text="Donuts" onCategorySelect={handleCategorySelection} />
                    <CategoryItem imgSrc={cookies} text="Cookies" onCategorySelect={handleCategorySelection} />
                </div>
                <PrimaryButton type="button" color="blue" onClick={handleNextClick}>Next</PrimaryButton>
            </main>
            <Footer />
        </div>
    );
}

export default ChooseCategory;
