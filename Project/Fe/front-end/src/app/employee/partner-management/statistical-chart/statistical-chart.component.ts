import { Component, OnInit } from '@angular/core';
import {Accesstimes} from '../../../models/accesstimes';
import {AddressCounts} from '../../../models/address-counts';
import {CustomerService} from '../../../services/customer.service';
import {AgeCounts} from '../../../models/age-counts';
import {BuyCount} from '../../../models/buy-count';

@Component({
  selector: 'app-statistical-chart',
  templateUrl: './statistical-chart.component.html',
  styleUrls: ['./statistical-chart.component.scss']
})
export class StatisticalChartComponent implements OnInit {
  // tslint:disable-next-line:ban-types
  dataSource: Object;
  // tslint:disable-next-line:ban-types
  dataSource2: Object;

  type = 'msline';
  dataFormat = 'json';
  data: any;
  dataSource3 = new Object();
  dataSource4 = new Object();
  dataSource5 = new Object();
  addressCounts: AddressCounts[];
  ageCounts: AgeCounts[];
  buyCounts: BuyCount[];
  promiseCounts: any;
  constructor(private customerService: CustomerService) {
  }

  ngOnInit(): void {
    this.customerService.findAllAddress().subscribe(next => {
      this.addressCounts = next;
      this.data = {
        chart: {
          // chú thích
          caption: 'Biểu Đồ Thống Kê Theo Địa Chỉ Khách Hàng',
          subCaption: 'Thống kê 10 tỉnh thành phố có khách hàng nhiều nhất năm 2020',
          xAxisName: 'Tỉnh,Thành Phố',
          yAxisName: 'Người',
          numberSuffix: 'người',
          theme: 'fusion'
        },
        categories: [
          {
            category: [
              {
                label: this.addressCounts[0].addressUser
              },
              {
                label: this.addressCounts[1].addressUser
              },
              {
                label: this.addressCounts[2].addressUser
              },
              {
                label: this.addressCounts[3].addressUser
              },
              {
                label: this.addressCounts[4].addressUser
              },
              {
                label: this.addressCounts[5].addressUser
              },
              {
                label: this.addressCounts[6].addressUser
              },
              {
                label: this.addressCounts[7].addressUser
              },
              {
                label: this.addressCounts[8].addressUser
              },
              {
                label: this.addressCounts[9].addressUser
              },
            ]
          }
        ],
        dataset: [
          {
            data: [
              {
                value: this.addressCounts[0].counts,
              },
              {
                value: this.addressCounts[1].counts
              },
              {
                value: this.addressCounts[2].counts
              },
              {
                value: this.addressCounts[3].counts
              },
              {
                value: this.addressCounts[4].counts
              },
              {
                value: this.addressCounts[5].counts
              },
              {
                value: this.addressCounts[6].counts
              },
              {
                value: this.addressCounts[7].counts
              },
              {
                value: this.addressCounts[8].counts
              },
              {
                value: this.addressCounts[9].counts
              },
            ]
          }
        ]
      };
      this.dataSource3 = this.data;
    });
    this.customerService.findAllAge().subscribe(next => {
      this.ageCounts = next;
      this.data = {
        chart: {
          // chú thích
          caption: 'Biểu Đồ Thống Kê Theo Độ Tuổi Khách Hàng',
          subCaption: 'Thống kê độ tuổi của khách hàng trong năm 2020',
          xAxisName: 'Độ tuổi',
          yAxisName: 'Số Người',
          numberSuffix: 'người',
          theme: 'fusion'
        },
        categories: [
          {
            category: [
              {
                label: this.ageCounts[0].group
              },
              {
                label: this.ageCounts[1].group
              },
              {
                label: this.ageCounts[2].group
              },
              {
                label: this.ageCounts[3].group
              },
            ]
          }
        ],
        dataset: [
          {
            data: [
              {
                value: this.ageCounts[0].counts,
              },
              {
                value: this.ageCounts[1].counts
              },
              {
                value: this.ageCounts[2].counts
              },
              {
                value: this.ageCounts[3].counts
              },
            ]
          }
        ]
      };
      this.dataSource4 = this.data;
    });
    this.customerService.findAllBuyCount().subscribe(next => {
      this.buyCounts = next;
      this.data = {
        chart: {
          // chú thích
          caption: 'Biểu Đồ Thống Kê Theo Số Lần Mua Của Khách Hàng',
          subCaption: 'Thống kê 10 khách hàng có số lần mua cao nhất',
          xAxisName: 'Tên Khách Hàng',
          yAxisName: 'Số lần mua',
          numberSuffix: 'lần',
          theme: 'fusion'
        },
        categories: [
          {
            category: [
              {
                label: this.buyCounts[0].nameUser
              },
              {
                label: this.buyCounts[1].nameUser
              },
              {
                label: this.buyCounts[2].nameUser
              },
              {
                label: this.buyCounts[3].nameUser
              },
              {
                label: this.buyCounts[4].nameUser
              },
              {
                label: this.buyCounts[5].nameUser
              },
              {
                label: this.buyCounts[6].nameUser
              },
              {
                label: this.buyCounts[7].nameUser
              },
              {
                label: this.buyCounts[8].nameUser
              },
              {
                label: this.buyCounts[9].nameUser
              },
            ]
          }
        ],
        dataset: [
          {
            data: [
              {
                value: this.buyCounts[0].counts,
              },
              {
                value: this.buyCounts[1].counts,
              },
              {
                value: this.buyCounts[2].counts,
              },
              {
                value: this.buyCounts[3].counts,
              },
              {
                value: this.buyCounts[4].counts,
              },
              {
                value: this.buyCounts[5].counts,
              },
              {
                value: this.buyCounts[6].counts,
              },
              {
                value: this.buyCounts[7].counts,
              },
              {
                value: this.buyCounts[8].counts,
              },
              {
                value: this.buyCounts[9].counts,
              },
            ]
          }
        ]
      };
      this.dataSource5 = this.data;
    });
  }
}
