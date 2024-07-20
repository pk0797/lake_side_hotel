import React, { useEffect, useState } from 'react'
import { getRoomTypes } from '../utils/ApiFunctions';

/* This declares a functional component that accepts handleRoomInputChange and newRoom as props. */
const RoomTypeSelector = ({handleRoomInputChange, newRoom}) => {

    /* These lines initialize state variables using the useState hook. */
    const [roomTypes, setRoomTypes] = useState([""]);
    const [showNewRoomTypeInput, setShowNewRoomTypesInput] = useState(false)
    const [newRoomType, setNewRoomType] = useState("")

    /* This hook fetches room types when the component mounts and updates the roomTypes state. */
    useEffect(() => {
        getRoomTypes().then((data) => {
            setRoomTypes(data)
        })
    }, [])

    /* This function updates the newRoomType state when the user types in the new room type input. */
    const handleNewRoomTypeInputChange = (e) => {
        setNewRoomType(e.target.value);
    }

    /* This function adds a new room type to the roomTypes array if it's not empty. */
    const handleAddNewRoomType = () => {
        if(newRoomType !== ""){
            setRoomTypes([...roomTypes, newRoomType])
            setNewRoomType("")
            setShowNewRoomTypesInput(false)
        }
    }

    /* This section returns the JSX to be rendered, but only if there are room types available. */
    return (
        <>
        {roomTypes.length > 0 && (
            <div>
                {/* This dropdown allows users to select an existing room type or choose to add a new one. */}
                <select 
                required
                className='form-select'
                name="roomType" 
                id="roomType"
                value={newRoom.roomType}
                onChange={(e) => {
                    if(e.target.value === "Add New"){
                        setShowNewRoomTypesInput(true)
                    }
                    else{
                        handleRoomInputChange(e)
                    }
                }}
                >
                    <option value = {""}> Select a room type </option>
                    <option value={"Add New"}> Add New</option>
                    {roomTypes.map((type, index) => (
                        <option key={index} value={type}>
                            {type}
                        </option>
                    ))}
                </select>
                {/* This section renders an input field and button for adding a new room type when showNewRoomTypeInput is true. */}
                {showNewRoomTypeInput && (
                    <div className = 'input-group'>
                        <input 
                        className='form-control'
                        type="text"
                        placeholder='Enter a new room type' 
                        onChange={handleNewRoomTypeInputChange}
                        />
                        <button className='btn btn-hotel' 
                        type='button'
                        onClick={handleAddNewRoomType}>
                            Add
                        </button>
                    </div>
                )}
            </div>
        )}
        </>
    )
}

/* This exports the RoomTypeSelector component so it can be used in other parts of the application. */
export default RoomTypeSelector