import axios from "axios";

const BASE_URL = "http://localhost:8080/api/staff";

export const getAllStaff = () => axios.get(`${BASE_URL}/read`);

export const getStaffById = (id) => axios.get(`${BASE_URL}/read/${id}`);

export const addStaff = (staff) => axios.post(`${BASE_URL}/add`, staff);

export const updateStaff = (id, staff) => axios.put(`${BASE_URL}/edit/${id}`, staff);

export const deleteStaff = (id) => axios.delete(`${BASE_URL}/delete/${id}`);

export const countStaff = () => axios.get(`${BASE_URL}/count`);

export const searchStaff = (department, manager, id = null) => {
  let url = `${BASE_URL}/search?department=${department}&manager=${manager}`;   
    if (id) {   
        url += `&id=${id}`;
    }
    return axios.get(url);
}
