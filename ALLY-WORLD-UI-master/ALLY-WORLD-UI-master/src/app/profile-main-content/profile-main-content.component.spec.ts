import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfileMainContentComponent } from './profile-main-content.component';

describe('ProfileMainContentComponent', () => {
  let component: ProfileMainContentComponent;
  let fixture: ComponentFixture<ProfileMainContentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProfileMainContentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProfileMainContentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
