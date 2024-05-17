// CategoryContext.js
import React, { createContext, useState, useContext } from 'react';

const CategoryContext = createContext();

export const CategoryProvider = ({ children }) => {
    const [chosenCategory, setChosenCategory] = useState('');

    return (
        <CategoryContext.Provider value={{ chosenCategory, setChosenCategory }}>
            {children}
        </CategoryContext.Provider>
    );
};

export const useCategory = () => {
    return useContext(CategoryContext);
};
