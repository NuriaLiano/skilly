
export class PlaymobilService {

    async getFetch(url) {
        let response;
        const token = window.sessionStorage.getItem("token");
        const headers = new Headers();
        headers.append("Authorization", `Bearer ${token}`);
        headers.append("Content-Type", "application/x-www-form-urlencoded");

        response = await fetch(url, {
            method: "get",
            headers
        });
        return response;
    }

    async getResponse() {
        const url = "http://127.0.0.1:8082/api/series";
        let response;
        // const token = window.sessionStorage.getItem("token");
        try {
            response = await this.getFetch(url);
        } catch (error) {
            throw new Error(`Cannot retrieve series: ${error}`);
        }
        if (!response.ok) {
            throw new Error(`Cannot retrieve series: [${response.status} ${response.statusText}]`);
        }
        let data;
        try {
            data = await response.json();
        } catch(error) {
            throw new Error(`Cannot retrieve series: ${error}`);
        }
        if (!data.ok) {
            throw new Error(`Cannot retrieve series: ${data.message}`);
        }
        return data.series;
    }

    async getSeriesId(id) {
        const url = `http://127.0.0.1:8082/api/serie/${id}/boxes`;
        let response;
        try {
            response = await this.getFetch(url);
        } catch (error) {
            throw new Error(`Cannot retrieve series: ${error}`);
        }
        if (!response.ok) {
            throw new Error(`Cannot retrieve series: [${response.status} ${response.statusText}]`);
        }
        let data;
        try {
            data = await response.json();
        } catch(error) {
            throw new Error(`Cannot retrieve series: ${error}`);
        }
        if (!data.ok) {
            throw new Error(`Cannot retrieve series: ${data.message}`);
        }
        return data.boxes;
    }

    async getBoxesId(id) {
        const url = `http://127.0.0.1:8082/api/box/${id}/figures`;
        let response;
        try {
            response = await this.getFetch(url);
        } catch (error) {
            throw new Error(`Cannot retrieve series: ${error}`);
        }
        if (!response.ok) {
            throw new Error(`Cannot retrieve series: [${response.status} ${response.statusText}]`);
        }
        let data;
        try {
            data = await response.json();
        } catch(error) {
            throw new Error(`Cannot retrieve series: ${error}`);
        }
        if (!data.ok) {
            throw new Error(`Cannot retrieve series: ${data.message}`);
        }
        const figuresId = data.figures.map(figura => figura.figure);
        return figuresId;
    }

    async showBoxes(boxes) {
        let response;
        let boxesA = [];
        for (const box of boxes) {
            const url = `http://127.0.0.1:8082/api/box/${box}`;
            try {
            response = await this.getFetch(url);
            } catch (error) {
                throw new Error(`Cannot retrieve boxes: ${error}`);
            }
            if (!response.ok) {
                throw new Error(`Cannot retrieve boxes: [${response.status} ${response.statusText}]`);
            }
            let data;
            try {
                data = await response.json();
            } catch(error) {
                throw new Error(`Cannot retrieve boxes: ${error}`);
            }
            if (!data.ok) {
                throw new Error(`Cannot retrieve boxes: ${data.message}`);
            }
            boxesA.push({"id":data.box._uuid, "name": data.box._denomination, "price": data.box._price });
        }
        return boxesA;
    }

    async showFigures(figures) {
        let response;
        let figuresA = [];
        for (const figure of figures) {
            const url = `http://127.0.0.1:8082/api/figure/${figure}`;
            try {
                response = await this.getFetch(url);
            } catch (error) {
                throw new Error(`Cannot retrieve figures: ${error}`);
            }
            if (!response.ok) {
                throw new Error(`Cannot retrieve figures: [${response.status} ${response.statusText}]`);
            }
            let data;
            try {
                data = await response.json();
            } catch(error) {
                throw new Error(`Cannot retrieve figures: ${error}`);
            }
            if (!data.ok) {
                throw new Error(`Cannot retrieve figures: ${data.message}`);
            }
            figuresA.push({ "name": data.figure.denomination, "barcode": data.figure.barcode });
        }
        return figuresA;
    }
}