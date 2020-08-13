import {Component, OnInit} from '@angular/core';
import * as $ from 'jquery';
import {AbstractControl, FormBuilder, FormGroup, Validators} from '@angular/forms';
import {AdminService} from '../../services/admin.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {Account} from '../../models/account';
import {Employees} from '../../models/employees';
import {Role} from '../../models/role';
import {Md5} from 'ts-md5';
import {CustomerService} from '../../services/customer.service';
import {Customer} from '../../models/customer';

@Component({
  selector: 'app-list-account',
  templateUrl: './list-account.component.html',
  styleUrls: ['./list-account.component.scss']
})
export class ListAccountComponent implements OnInit {
  accountList: Account[] = [];
  accountlist: Account[] = [];
  roleList: Role[];
  accountForm: FormGroup;
  editAccountForm: FormGroup;
  p = 1;
  infoAccountById: Employees = new Employees();
  infoAccountById2: Customer = new Customer();
  AccountById: Account = new Account();
  editResuilt: Account;
  size = 6;
  pageClicked = 0;
  pages = [];
  search = '';
  totalPages = 1;
  promiseAccount: any;

  constructor(private adminService: AdminService,
              private route: Router,
              private formBuilder: FormBuilder,
              private activatedRoute: ActivatedRoute,
              private customerService: CustomerService) {
  }

  ngOnInit(): void {
    this.adminService.findAllRole().subscribe(next => {
      this.roleList = next;
    }, error => {
      console.log(error);
    });
    this.adminService.findAll().subscribe(next => {
      this.accountlist = next;
    }, error => {
      console.log(error);
    });
    this.activatedRoute.paramMap.subscribe((param: ParamMap) => {
      this.search = param.get('accountName');
      if (this.search === null) {
        this.search = '';
      }
    });
    this.getAll();
    this.accountForm = this.formBuilder.group({
      accountId: [''],
      accountName: [''],
      accountPassword: [''],
      deleteFlag: [''],
      role: [''],
    });
    this.editAccountForm = this.formBuilder.group({
      accountId: ['', [Validators.required]],
      accountName: ['', [Validators.pattern('^[a-zA-Z0-9\\,\\.\\-\\_\\@]{1,}$'), this.existAccountName.bind(this)]],
      accountPassword: ['', [Validators.pattern('^[a-zA-Z0-9]{1,}$')]],
      deleteFlag: ['', [Validators.required]],
      role: ['', [Validators.required]]
    });
  }

  // tslint:disable-next-line:typedef
  existAccountName(c: AbstractControl) {
    const v = c.value;
    for (const acc of this.accountlist) {
      if (acc.accountName === v && v !== this.AccountById.accountName) {
        return {nameAccountExist: true};
      }
    }
    return null;
  }

  getAll(): void {
    this.getAllSubmit(0);
  }

  // tslint:disable-next-line:typedef
  getAllSubmit(page) {
    const md5 = new Md5();
    this.adminService.getAllCourse(page, this.size, this.search).subscribe(
      data => {
        this.pageClicked = page;
        this.accountList = data.content;
        // tslint:disable-next-line:prefer-for-of
        for (let i = 0; i < this.accountList.length; i++) {
          this.accountList[i].accountPassword = md5.appendAsciiStr(this.accountList[i].accountPassword as string).end();
        }
        this.totalPages = data.totalPages;
        this.pages = Array.apply(null, {length: this.totalPages}).map(Number.call, Number);
      }, error => console.log(error)
    );
  }

  // tslint:disable-next-line:typedef
  onPrevious() {
    if (this.pageClicked > 0) {
      this.pageClicked--;
      this.getAllSubmit(this.pageClicked);
    }
  }

  // tslint:disable-next-line:typedef
  onNext() {
    if (this.pageClicked < this.totalPages - 1) {
      this.pageClicked++;
      this.getAllSubmit(this.pageClicked);
    }
  }

  // tslint:disable-next-line:typedef
  onFirst() {
    this.pageClicked = 0;
    this.getAllSubmit(this.pageClicked);
  }

  // tslint:disable-next-line:typedef
  onLast() {
    this.pageClicked = this.totalPages - 1;
    this.getAllSubmit(this.pageClicked);
  }

  // tslint:disable-next-line:typedef
  info(id) {
    this.infoAccountById.position = null;
    this.adminService.findByInfoId(id).subscribe(next => {
      this.infoAccountById = next;
    }, error => {
      console.log(error);
    });
    if (this.infoAccountById.position === null) {
      this.customerService.getCustomerById(id).subscribe(next => {
        this.infoAccountById2 = next;
      }, error => {
        console.log(error);
      });
    }
    $('#infor').show();
    // tslint:disable-next-line:only-arrow-functions typedef
    $('.close').click(function() {
      $('#infor').hide();
    });
  }

  // tslint:disable-next-line:typedef
  edit(id) {
    this.infoAccountById = new Employees();
    this.adminService.findByInfoId(id).subscribe(next => {
      this.infoAccountById = next;
    });
    this.customerService.getCustomerById(id).subscribe(next => {
      this.infoAccountById2 = next;
      // tslint:disable-next-line:no-shadowed-variable
    }, error => {
      console.log(error);
    });
    this.adminService.findAllRole().subscribe(next => {
      this.roleList = next;
    }, error => {
      console.log(error);
    });
    this.adminService.findAccountById(id).subscribe(next => {
      this.AccountById = next;
    }, error => {
      console.log(error);
    });
    this.adminService.findAccountById(id).subscribe(next => {
      this.editAccountForm.patchValue({
        accountId: next.accountId,
        accountName: '',
        accountPassword: '',
        deleteFlag: next.deleteFlag,
        role: next.role.roleId
      });
    }, error => {
      console.log(error);
    });
    $('#edit').show();
    // tslint:disable-next-line:only-arrow-functions typedef
    $('.close').click(function() {
      $('#edit').hide();
    });
    // tslint:disable-next-line:only-arrow-functions typedef
    $('.destroy').click(function() {
      $('#edit').hide();
    });
  }

// tslint:disable-next-line:typedef
  delete(id) {
    this.adminService.findAccountById(id).subscribe(next => {
      this.AccountById = next;
    }, error => {
      console.log(error);
    });
    $('#delete').show();
    // tslint:disable-next-line:only-arrow-functions typedef
    $('.close').click(function() {
      $('#delete').hide();
    });
    // tslint:disable-next-line:only-arrow-functions typedef
    $('.destroy').click(function() {
      $('#delete').hide();
    });
    // tslint:disable-next-line:only-arrow-functions typedef
  }

  // tslint:disable-next-line:typedef
  create() {
    this.adminService.findRoleById(this.accountForm.get('role').value).subscribe(
      next => {
        // this.accountForm.patchValue({
        //   role: next,
        //   deleteFlag: 0,
        // });
        this.promiseAccount = new Promise(resolve => resolve(next));
        this.promiseAccount.then((value) => {
          this.accountForm.value.role = value;
          this.adminService.create(this.accountForm.value).subscribe(
            () => {
              this.getAll();
              $('#close').click();
            },
            error => console.log(error)
          );
        });
      }
    );


  }

  // tslint:disable-next-line:typedef
  deleted(accountId) {
    this.adminService.deleteById(accountId).subscribe(next => {
      window.location.reload();
    }, error => {
      console.log(error);
    });
  }

  // tslint:disable-next-line:typedef
  onSubmit() {
    this.editResuilt = new Account();
    this.editResuilt.accountId = this.editAccountForm.value.accountId;
    // tslint:disable-next-line:max-line-length
    this.editResuilt.accountName = this.editAccountForm.value.accountName !== '' ? this.editAccountForm.value.accountName : this.AccountById.accountName;
    // tslint:disable-next-line:max-line-length
    this.editResuilt.accountPassword = this.editAccountForm.value.accountPassword !== '' ? this.editAccountForm.value.accountPassword : this.AccountById.accountPassword;
    this.editResuilt.deleteFlag = this.editAccountForm.value.deleteFlag;
    this.adminService.findRoleById(this.editAccountForm.value.role).subscribe(next => {
      this.editResuilt.role = next;
      this.adminService.edit(this.editResuilt).subscribe(next2 => {
        window.location.reload();
      }, error => {
        console.log(error);
      });
    }, error => {
      console.log(error);
    });
  }
}
