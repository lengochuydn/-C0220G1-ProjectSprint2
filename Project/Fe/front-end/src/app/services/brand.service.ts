import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Brand} from '../models/brand';

@Injectable()
export class BrandService {
  private API_URL = 'http://localhost:8080/warehouse-management/brand';

  constructor(private http: HttpClient) {
  }

  getAllBrand(curentPage, size, search): Observable<any> {
    return this.http.get(this.API_URL + '?page=' + curentPage + '&size=' + size + '&search=' + search);
  }

  createBrand(brand: Partial<Brand>): Observable<Brand> {
    return this.http.post<Brand>(this.API_URL + '/create', brand);
  }

  findById(id: number): Observable<Brand> {
    return this.http.get<Brand>(this.API_URL + '/' + id);
  }

  editBrand(brand): Observable<Brand> {
    return this.http.put<Brand>(this.API_URL + '/update/' + brand.id, brand);
  }

  deleteBrand(brand): Observable<Brand> {
    return this.http.patch<Brand>(this.API_URL + '/delete/' + brand.id, brand);
  }
}
